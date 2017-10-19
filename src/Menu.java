import RegLogin.Account;
import RegLogin.CityMap;
import RegLogin.idTest;
import item.ForRentMessage;
import item.Request;
import java.util.Scanner;
public class Menu {
    static boolean isLogin=false;//账号登录状态
    static boolean isRegin=false;//账号注册状态
    private boolean isRented=false;//房屋出租状态
    Scanner scanner=new Scanner(System.in);
    static Account account;
    Request request;
    String reply;
    Lodger lodger;

    /**
     * 登录界面BUG，只能验证账号密码，无法获取账号信息
     * 出现状况，输入正确的账号密码，会回馈一串乱码，并且显示密码有误。
     *
     */
    public void RegLogin(){
        System.out.println("*****欢迎光临BIM房屋租赁系统菜单*****");
        System.out.println(
                "1、登录\n"+
               "2、注册\n"+
                "3、退出"
        );
        System.out.println("请输入您的选择: ");
        switch (scanner.nextInt()){
            case 1:
                Login();
                break;
            case 2:
                Regin();
                break;
            case 3:
                System.exit(0);
                break;
        }
    }

    /**
     * 登录功能方法
     */
    public void Login(){
        account=new Account();
        request=new Request();
        System.out.println("请输入您的账号：");
        account.setUserName(scanner.next());
        System.out.println("请输入您的密码：");
        account.setPassword(scanner.next());
        request.setType("登录");
        request.setAccount(account);
        Lodger.ClientSend(request);
        if (isLogin){
            System.out.println("选择您要进入的客户端，1.房客 2.房东");
            switch (scanner.nextInt()){
                case 1:account.setType("Lodger");
                    break;
                case 2:
                    account.setType("Landlord");
                    break;
            }
            SecMenu();
        }
        else {System.out.println("您输入的密码有误，请重新输入");
            Login();
        }
    }

    /**
     * 注册功能方法
     */
    public void Regin(){
        account=new Account();
        request=new Request();
        request.setType("注册");
        idTest idtest=new idTest();//实名验证类
        CityMap.getMap();//实名验证类里的地区获取
        String id;//身份证ID字符串
        System.out.println("请输入您的账号：");
        account.setUserName(scanner.next());
        System.out.println("请输入您的密码：");
        account.setPassword(scanner.next());
        System.out.println("请再次输入您的密码：");
        String pw=scanner.next();
        if (!(pw.equals(account.getPassword()))){
            System.out.println("您两次输入的密码不相同，请重新输入");
            Regin();
        }
        System.out.println("请输入您的电话号码：");
        account.setPhoneNumber(scanner.next());
        System.out.println("请输入您的类型：1.房客 2.房东");
        switch (scanner.nextInt()){
            case 1:
                account.setType("Lodger");
                break;
            case 2:
                account.setType("Landlord");
                break;
        }
        do{
            System.out.println("请输入您的身份证号码： ");
            id=scanner.next(); }
        while (!idtest.idLegit(id));
        account.setIdnum(id);
        request.setAccount(account);
        Lodger.ClientSend(request);
        if (isRegin){
            SecMenu();
        }
        else {System.out.println("账号重复，请重新注册");
             Regin();}
    }
    //二级菜单
    public void SecMenu() {
        System.out.println("*****欢迎光临BIM房屋租赁系统菜单*****");
        switch (account.getType()){
            case "Lodger":
                System.out.println(
                        "1、查看服务器端信息\n" +
                                "2、发布求租信息\n" +
                                "3、搜索信息\n" +
                                "4、聊天窗口\n" +
                                "5、查看订单\n" +
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
                                "5、查看订单\n" +
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
    //查看服务器信息
    public void SeverShow(){
        System.out.println("*****欢迎光临BIM房屋租赁系统菜单*****");
        System.out.println(
                "1、查看出租信息\n" +
                        "2、查看求租信息\n" );
        showRent();

    }
    //查看求出租信息
    public void showRent(){

        ForRentMessage forRentMessage=new ForRentMessage();
        request=new Request();
        switch (scanner.nextInt()) {
            case 1: forRentMessage.setRentOrNot("出租");
                break;
            case 2: forRentMessage.setRentOrNot("求租");
                break;
        }
        request.setForRentMessage(forRentMessage);
        request.setType("租赁信息");
        Lodger.ClientSend(request);
        SecMenu();
    }
    //查看求租信息

    //发布求/租房信息
    public void RentInfo(){
        request=new Request();
        ForRentMessage forRentMessage=new ForRentMessage();
        System.out.println("输入户型");
        forRentMessage.setRoomType(scanner.next());
        System.out.println("输入地址");
        forRentMessage.setAddress(scanner.next());
        System.out.println("输入联系方式");
        forRentMessage.setPhoneNumber(scanner.next());
        System.out.println("请选择：1.求租 2.出租");
        switch (scanner.nextInt()){
            case 1:
                forRentMessage.setRentOrNot("求租");
                break;
            case 2:
                forRentMessage.setRentOrNot("出租");
                break;
        }
        forRentMessage.setAccount(account);
        request.setForRentMessage(forRentMessage);
        request.setAccount(account);
        request.setType("发布信息");
        Lodger.ClientSend(request);
        SecMenu();
    }

    //搜索信息
    public void Search(){

    }
    //4聊天
    public void Chat(){

    }
    //5查看订单
    public void Order() {
            switch (account.getType()) {
                case "Lodger":
                    System.out.println(
                            "①下订单\n" +
                                    "②取消订单\n" +
                                    "③完成订单\n" );
                    break;
                case "Landlord":
                    System.out.println(
                            "①确认订单\n" +
                                    "②取消订单\n" +
                                    "③完成订单\n" );
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

    //6信誉积分
    public void CreditPoint(){

    }
    //7支付模块
    public void Payment(){

    }
    //8退出模块
    public static void Exit(){
        Request request=new Request();
        request.setType("退出");
        Lodger.ClientSend(request);
        System.exit(0);
    }
    public static void main(String[] args) {
        Menu menu=new Menu();
        menu.RegLogin();
    }
}
