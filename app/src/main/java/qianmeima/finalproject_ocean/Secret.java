package qianmeima.finalproject_ocean;

/**
 * Created by Ailee on 2016/4/21.
 */
public class Secret {

    public String Stitle;
    public String Sarticle;


    public Secret() {
        this("", "");
    }

    public Secret(String name, String info) {
        this.Stitle = name;
        this.Sarticle = info;

    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Secret))
            return false;

        Secret secret = (Secret) object;
        return Stitle.equals(secret.Stitle);
    }
}
