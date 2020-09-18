package thinking.in.spring.bean.definition;

public class test {
    public static void main(String[] args) {
        String s = "<?xml version=\"1.0\" encoding=\"GBK\"?>\n" +
                "<in>\n" +
                "\t<head>\n" +
                "\t\t<ans_tran_code>BJCEBQBIReq</ans_tran_code>\n" +
                "\t\t<acq_ins_id_cd>04202220</acq_ins_id_cd>\n" +
                "\t\t<trm_seq_num>1001603214</trm_seq_num>\n" +
                "\t\t<timestamp>2020-09-17 16:53:53</timestamp>\n" +
                "\t</head>\n" +
                "\t<tin>\n" +
                "\t\t<business_params>\n" +
                "\t\t\t<inst_id>1111</inst_id>\n" +
                "\t\t\t<bill_key>0659</bill_key>\n" +
                "\t\t\t<company_id>010026606</company_id>\n" +
                "\t\t\t<begin_num>1</begin_num>\n" +
                "\t\t\t<query_num>1</query_num>\n" +
                "\t\t\t<user_id></user_id>\n" +
                "\t\t\t<ceb_track></ceb_track>\n" +
                "\t\t\t<act_period></act_period>\n" +
                "\t\t\t<area_code></area_code>\n" +
                "\t\t\t<field1></field1>\n" +
                "\t\t\t<field2></field2>\n" +
                "\t\t\t<field3></field3>\n" +
                "\t\t\t<field4></field4>\n" +
                "\t\t</business_params>\n" +
                "\t</tin>\n" +
                "</in>";
        String substring = s.substring(6);
        System.out.println(substring);
    }
}
