package so.go2.sharingthegym.adapter;

/**
 * Created by wentai on 17-5-13.
 */

public class Food {

    private int imgId;
    private String info;

    public Food(int imgId, String info) {
        this.imgId = imgId;
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public int getImgId() {
        return imgId;
    }

}
