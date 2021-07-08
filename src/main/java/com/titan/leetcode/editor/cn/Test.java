package com.titan.leetcode.editor.cn;

/**
 * @author Titan
 * @className Test
 * @description TODO
 * @date 2021/7/6 下午3:24
 */
public class Test {
    private static String sql_overview = "\n" +
            "SELECT\n" +
            "    sum(customer_count) AS \"totalSumCurr\",\n" +
            "    max(customer_count) AS \"totalMaxCurr\",\n" +
            "    sum(customer_count) / {cal_days} AS \"totalAvgCurr\",\n" +
            "    (CASE WHEN coalesce(sum(all_count), 0)=0 THEN 0 ELSE round(sum(good_count) / sum(all_count)::DECIMAL, 4) END) AS \"totalSatCurr\"\n" +
            "FROM (\n" +
            "SELECT tmp2.stat_at AS date,\n" +
            "       tmp1.customer_count,\n" +
            "       tmp1.call_customer_count,\n" +
            "       tmp1.im_customer_count,\n" +
            "       tmp1.satisfaction_count + tmp3.satisfaction_count AS all_count,\n" +
            "       tmp1.satisfied_count + tmp3.satisfied_count AS good_count\n" +
            "FROM (\n" +
            "SELECT\n" +
            "    TO_CHAR(stat_at, 'yyyy-mm-dd') AS \"date\",\n" +
            "       SUM(total_served_customer_count) AS customer_count,\n" +
            "       SUM(cc_served_customer_count) AS call_customer_count,\n" +
            "       SUM(im_served_customer_count) AS im_customer_count,\n" +
            "       coalesce(SUM(cc_satisfaction_count), 0) AS satisfaction_count,\n" +
            "       coalesce(SUM(cc_satisfied_count), 0) AS satisfied_count\n" +
            "FROM nbi_customer_served_overview_day\n" +
            "    WHERE company_id = {company_id} AND stat_at BETWEEN '{ statAtBegin }' AND '{ statAtEnd }'\n" +
            "\n" +
            "    GROUP BY date ) as tmp1\n" +
            " FULL OUTER JOIN\n" +
            " (SELECT TO_CHAR(GENERATE_SERIES('{ statAtBegin }' :: TIMESTAMP, '{ statAtEnd }' :: TIMESTAMP, '1 day'), 'yyyy-mm-dd') AS stat_at)tmp2 ON tmp1.date = tmp2.stat_at\n" +
            "\n" +
            "FULL OUTER JOIN (\n" +
            "\n" +
            "SELECT TO_CHAR(stat_at, 'yyyy-mm-dd') AS stat_at2,\n" +
            "       coalesce(SUM(appraise_0_count), 0) + coalesce(SUM(appraise_1_count), 0) AS satisfied_count,\n" +
            "       coalesce(SUM(appraise_count),0) AS satisfaction_count\n" +
            "FROM nbi_im_whole_trend_hour\n" +
            "WHERE company_id = {company_id} AND stat_at BETWEEN '{ statAtBegin }' AND '{ statAtEnd }'\n" +
            "    GROUP BY stat_at2\n" +
            "    ) as tmp3 ON tmp3.stat_at2 = tmp2.stat_at ) as tmp ";
    public static void main(String[] args) {
        System.out.println(sql_overview);
    }
}
