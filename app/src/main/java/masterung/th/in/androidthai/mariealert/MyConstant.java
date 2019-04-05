package masterung.th.in.androidthai.mariealert;

public class MyConstant {

    //    Field
    private String urlGetUserWhereUser = "http://tscore.ms.ac.th/App/getUserWhereUserAndroid.php";

    private String rememberFile = "remember";
    private String titleHaveSpace = "มีช่องว่างเกิิดขึ้น";
    private String messageHaveSpace = "กรุณากรอง ทุกช่อง คะ";
    private String titleUserFalse = "User ผิด";
    private String messageUserFalse = "ไม่มี User นี่ในฐานข้อมูล คะ";
    private String titlePasswordFalse = "Password ผิด";
    private String messagePasswordFalse = "พิมพ์ Password ใหม่ คะ";




//    Getter


    public String getTitleUserFalse() {
        return titleUserFalse;
    }

    public String getMessageUserFalse() {
        return messageUserFalse;
    }

    public String getTitlePasswordFalse() {
        return titlePasswordFalse;
    }

    public String getMessagePasswordFalse() {
        return messagePasswordFalse;
    }

    public String getUrlGetUserWhereUser() {
        return urlGetUserWhereUser;
    }

    public String getTitleHaveSpace() {
        return titleHaveSpace;
    }

    public String getMessageHaveSpace() {
        return messageHaveSpace;
    }

    public String getRememberFile() {
        return rememberFile;
    }
}
