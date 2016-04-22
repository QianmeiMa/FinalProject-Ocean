package qianmeima.finalproject_ocean;

import java.io.File;

/**
 * Created by Ailee on 2016/4/21.
 */
public class Photo {
    public String Ptitle;
    public File Pfile;

    public Photo(String ptitle, File pfile) {
        this.Pfile = pfile;
        this.Ptitle = ptitle;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Photo))
            return false;

        Photo photo = (Photo) object;
        return Ptitle.equals(photo.Ptitle);
    }
}
