/*
 * Copyright Vincent Blouin under the Mozilla Public License 1.1
 */

import org.neo4j.kernel.impl.util.FileUtils;
import org.triple_brain.service.Launch;

import java.io.File;
import java.io.IOException;

public class LaunchWebapp {

    public static void main(String[] args) throws Exception {
        deleteSolrIndex();
        Launch.before();
        Launcher launcher = new Launcher();
        launcher.launch();
        Launch.after();
    }

    private static void deleteSolrIndex(){
        try{
            File solrIndexFolder = new File(
                    "target/maven-shared-archive-resources/solr/data/index/"
            );
            FileUtils.deleteRecursively(
                    solrIndexFolder
            );
        }catch(IOException e){
            System.out.println("Couldn't delete solr index");
        }
        System.out.println("Solr index deleted");
    }
}
