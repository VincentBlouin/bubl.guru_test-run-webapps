/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

import guru.bubl.service.Launch;

public class LaunchWebapp {

    public static void main(String[] args) throws Exception {
        Launch.before();
        Launcher launcher = new Launcher();
        launcher.launch();
        Launch.after();
    }
}
