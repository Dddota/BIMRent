import RegLogin.Account;

import java.util.Scanner;

public class Menu {
/*    private String rent="出租";
    private String need="求租";*/
    private boolean isRented=false;//标记已出租的房屋信息。
    Scanner scanner=new Scanner(System.in);
    Account account;
    //主界面菜单
    //注册时选择房客或者房东，setType。
    public void RegLogin(){
        System.out.println("*****欢迎光临BIM房屋租赁系统菜单*****");
        System.out.println(
                "1、登录\n" +
                "2、注册\n" +
                "3、退出\n");
        switch (scanner.nextInt()){
            case 1:

                SecMenu();
                break;
            case 2:
                SecMenu();
                break;
            case 3:
                System.exit(0);
                break;
        }
    }
    //二级页面
    public void SecMenu() {
        System.out.println("*****欢迎光临BIM房屋租赁系统菜单*****");
        switch (account.getType()){
            case "Lodger":
                System.out.println(
                        "1、查看服务器端信息\n" +
                                "2、发布求租信息\n" +
                                "3、搜索信息\n" +
                                "4、聊天窗口\n" +
                                "5、订单\n" +
                                "6、信誉积分\n" +
                                "7、支付系统\n" +
                                "8、退出\n");
                break;
            case "Landlord":
                System.out.println(
                        "1、查看服务器端信息\n" +
                                "2、发布出租信息\n" +
                                "3、搜索信息\n" +
                                "4、聊天窗口\n" +
                                "5、订单\n" +
                                "6、信誉积分\n" +
                                "7、支付系统\n" +
                                "8、退出\n");
                break;
        }
        switch (scanner.nextInt()) {
            case 1:
                SeverShow();
                break;
            case 2:
                RentInfo();
                break;
            case 3:
                Search();
                break;
            case 4:
                Chat();
                break;
            case 5:
                Order();
                break;
            case 6:
                CreditPoint();
                break;
            case 7:
                Payment();
                break;
            case 8:
                System.exit(0);
                break;
        }
    }
    //查看服务端信息
    public void SeverShow(){
        System.out.println("*****欢迎光临BIM房屋租赁系统菜单*****");
        System.out.println(
                "1、查看出租信息\n" +
                        "2、查看求租信息\n" );
        switch (scanner.nextInt()) {
            case 1:
                break;
            case 2:
                break;
        }
    }
    //发布出租或者求租信息①户型（包含平米数②地址③联系方式


    public void RentInfo(){
    }

    //3、搜索信息 ①户型②地址搜索

    public void Search(){

    }
    //4、聊天窗口
    public void Chat(){

    }
    //5、查看订单
    public void Order() {
            switch (account.getType()) {
                case "Lodger":
                    System.out.println(
                            "1、下订单\n" +
                                    "2、取消订单\n" +
                                    "3、完成订单\n");
                    break;
                case "Landlord":
                    System.out.println(
                            "1、确认订单\n" +
                                    "2、取消订单\n" +
                                    "3、完成订单\n");
                    break;
            }
            switch (scanner.nextInt()) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
            }
        }

    //6、信誉积分
    public void CreditPoint(){

    }
    //7、支付系统
    public void Payment(){

    }
    public static void main(String[] args) {
        Menu menu=new Menu();
        menu.RegLogin();
    }
}
