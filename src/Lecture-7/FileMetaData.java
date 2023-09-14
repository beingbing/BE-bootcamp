import java.util.Date;

public class FileMetaData {
    Date CreatedOn;
    Date ModifiedOn;

    int version;

    public FileMetaData(Date cr, Date mod, int ver) {
        CreatedOn = cr;
        ModifiedOn = mod;
        version = ver;
    }
}