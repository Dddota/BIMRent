package item;

import RegLogin.Account;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class FileOperate {
    //新建一个文件
    File efile1 = new File("src/info/idinfo.txt");
    private boolean flag = false;
    private boolean isRight = false;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean isRight() {
        return isRight;
    }

    public void setRight(boolean right) {
        isRight = right;
    }

    /**
     * 实现对账号信息的写入
     *
     * @param str
     */
    public void createfile1(String str) {
        //创建类的对象
        FileOperate cf = new FileOperate();
        //判断文件是否创建的方法
        cf.isExit1(efile1);
        //使用FileWriter类实现文件的写入
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(efile1, true);
            bw = new BufferedWriter(fw);
            bw.write(str);
            bw.newLine();
            bw.flush();
            System.out.println("写入完毕！");
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 完成账户的登录
     * 验证账号登录
     */
    public boolean readFile(String str) {
        FileReader fr = null;
        BufferedReader br = null;

        try {
            //创建一个FileReader对象
            fr = new FileReader("src/info/idinfo.txt");
            //创建一个BufferedReader对象
            br = new BufferedReader(fr);
            String line = str;
            String[] str1 = line.split("@");
            String str11 = str1[1];
            String str12 = str1[3];
            String str21 = null;
            String str22 = null;
            line = br.readLine();
            while (line != null) {
                String[] str2 = line.split("@");
                str21 = str2[1];
                str22 = str2[3];
                if (str11.equals(str21)) {
                    flag = true;
                }
                if ((str11.equals(str21)) && (str12.equals(str22))) {
                    isRight = true;


                    break;
                }
                line = br.readLine();
            }
            System.out.println(str11);
            System.out.println(str21);
            System.out.println(str12);
            System.out.println(str22);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flag;
    }


    /**
     * 账号登录以后读取账号信息
     * 暂时无法解决信息和账号同时传递的问题，导致reply出现异常。
     * @param name
     * @return

    public Account readaccount(String name) {
       /Account acount = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            acount = new Account();
            fr = new FileReader("src/info/idinfo.txt");
            br = new BufferedReader(fr);
            String line = name;
            line = br.readLine();
            while (line != null) {
                String[] str2 = line.split("@");
                if (!str2[1].equals(name)) {
                    line = br.readLine();
                } else {
                    acount.setUserName(str2[1]);
                    acount.setPassword(str2[3]);
                    acount.setPhoneNumber(str2[5]);
                    acount.setIdnum(str2[7]);
                    acount.setType(str2[9]);
                    acount.setCreditPoint(Integer.parseInt(str2[11]));
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return acount;
   }*/

    /**
     * 账号注册
     *
     * @param account
     * @return 如果账号名重复，返回false
     */
    public boolean Regin(Account account) {
        FileReader fr = null;
        BufferedReader br = null;
        try {
            //创建一个FileReader对象
            fr = new FileReader("src/info/idinfo.txt");
            //创建一个BufferedReader对象
            br = new BufferedReader(fr);
            String line = account.getUserName();
            String str1 = line;
            line = br.readLine();
            while (line != null) {
                String[] str2 = line.split("@");
                String str21 = str2[1];
                line = br.readLine();
                if (str1.equals(str21)) {
                    isRight = false;
                    break;
                } else isRight = true;
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return isRight;
    }

    public void isExit1(File efile) {
        if (!efile.exists()) {
            try {
                efile.createNewFile();
                System.out.println("账号信息文件已创建");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    /**
     * 出租或求租信息
     *
     * @param request
     */
    public static void saveStringToTxt(Request request) {
        File file = new File("src/info/rentInfo");
        ForRentMessage rent = request.forRentMessage;
        String address = rent.getAddress();
        String phoneNum = rent.getPhoneNumber();
        String roomType = rent.getRoomType();
        String rentOrNot = rent.getRentOrNot();
        String user = rent.getAccount().getUserName();
        String res = "user=" + user +"@rentOrNot=" + rentOrNot + "@roomType=" + roomType + "@address=" + address + "@phoneNumber=" + phoneNum +  "\n";
        try {
            FileOutputStream fos = new FileOutputStream(file, true);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(res);
            bw.newLine();
            bw.flush();
            System.out.println(user + "发布的信息写入成功！");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取求出租信息。
     * @param str
     */
    public static StringBuffer readRentInfo(String str) {
        FileReader fr = null;
        BufferedReader br = null;
        StringBuffer info=null;
        try {
            info=new StringBuffer();
            //创建一个FileReader对象
            fr = new FileReader("src/info/rentInfo");
            //创建一个BufferedReader对象
            br = new BufferedReader(fr);
            String line = br.readLine();
            while (line!=null){
                if (-1!=line.indexOf(str)){
                String[] str1 = line.split("@");
                for (int i = 0; i < str1.length; i++) {
                    String []str2=str1[i].split("=");
                    info.append(str2[1]+" ");
            }}
                System.out.println("\n");
            line=br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return info;
    }

    public static void main(String[] args) {
        readRentInfo("求租");
    }
}
