package thinking.in.spring.dependency.lookup;

import java.io.*;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class test {
    public static final String IP_ADDR="localhost";
    public static final int PORT=8998;

    public static void main(String[] args) {
        String message = "00001453<?xml version=\"1.0\" encoding=\"UTF-8\"?><service><SysHead><SvcCd>10110001</SvcCd><ScnCd>01</ScnCd><CnsmrSysID>2001000</CnsmrSysID><CnsmrSrlNo>1170328160403023</CnsmrSrlNo><GlblSrlNo>全局流水号</GlblSrlNo><TxnDt>20150304</TxnDt><TxnTm>160532</TxnTm><OrgnlCnsmrSysID>2001000</OrgnlCnsmrSysID><TxnMd>ONLINE</TxnMd><OrgnlTmlIdNo>原始终端标识号</OrgnlTmlIdNo><TmlIdNo>终端标识号</TmlIdNo><OrgnlCnsmrSvcNo>原始消费方服务器编号</OrgnlCnsmrSvcNo><CnsmrSvcNo>消费方服务器编号</CnsmrSvcNo><UsrLng>用户语言</UsrLng><FileFlg>文件标志</FileFlg><MACVal>MAC值</MACVal><MACFctr>MAC因子</MACFctr><PINSd>PIN种子</PINSd><SvcVerNo>服务版本号</SvcVerNo><PrtyLvl>优先级别</PrtyLvl><VerfFlg>校验标志</VerfFlg><SysRsrv>系统保留</SysRsrv></SysHead><AppHead><InstId>机构Id</InstId><UsrNo>用户编号</UsrNo><UsrPswd>用户密码</UsrPswd><UsrLvl>用户级别</UsrLvl><UsrTp>用户类型</UsrTp><TlrSrlNo>柜员流水号</TlrSrlNo><CnlTp>渠道编号</CnlTp><CnlDtlTp>渠道细分</CnlDtlTp><FrntTxnCd>请求方交易码</FrntTxnCd></AppHead><BODY><Message>8=IMIX.1.0\u00019=298\u000135=W\u000149=CMDS\u000156=test_gzyh_fx\u000134=8\u000152=20201019-14:33:39.310\u000110235=6885215768635869648\u000110163=1\u000110164=D\u000110176=11\u0001555=1\u000110094=N\u0001602=CADCNY2Y=CFHB\u0001268=2\u0001269=1\u0001272=20201019\u0001270=1368.18\u000110413=4\u0001273=14:34:11.000\u0001269=1\u0001272=20201019\u0001270=1506.32\u000110413=1\u0001273=14:34:11.000\u000110358=2\u000110360=0\u000110359=CTSH\u000110360=1\u000110359=CTSH\u000110=666\u0001</Message></BODY></service>";
        System.out.println(message.getBytes().length);
        Socket socket = null;
        try {
            socket = new Socket(IP_ADDR, PORT);

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream doc = new DataOutputStream(socket.getOutputStream());

            doc.write(message.getBytes("GBK"));

            String ret = input.readUTF();
            System.out.println("return");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
