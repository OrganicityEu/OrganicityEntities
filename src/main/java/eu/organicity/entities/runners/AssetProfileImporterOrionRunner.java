package eu.organicity.entities.runners;

/**
 * Created by etheodor on 24/08/2016.
 */
public class AssetProfileImporterOrionRunner {


    public static void main(String[] args) throws Exception {
        if (args.length<4){
            System.err.println("Error: insufficient argument count!");
            System.err.println("Usage: AssetProfileImporterOrionRunner AssetDirectoryUrl jsonInputFilenameBorough jsonInputFilenameTrafficManualCount jsonInputFilenameTransport");
            System.exit(1);
        }
        String[] args2 = {"",""};
        args2[1]=args[0];
        args2[0]=args[1];
        BoroughProfileImporterOrionRunner.main(args);
        args2[0]=args[2];
        BoroughProfileImporterOrionRunner.main(args);
        args2[0]=args[3];
        TransportAssetImporterOrionRunner.main(args);
    }



}
