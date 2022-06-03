package de.immernochnoah.golf.file_system;

public class Config_File {

    public void createConfig() {
        File_Manager fm = new File_Manager();
        if(!fm.configIsExisting("PREFIX")) {
            fm.addConfigText("Prefix", "&6&lGolf &8:");
            fm.saveConfig("PREFIX");
        }
        if(!fm.configIsExisting("MESSAGES")) {
            fm.addConfigText("Join Nachricht", " &a%s &7ist dem Server beigetreten.");
            fm.addConfigText("Leave Nachricht", " &a%s &7hat den Server verlassen.");
            fm.addConfigText("Treffer Nachricht", " &7Du hast getroffen. &aGG! :D");
            fm.addConfigText("Nicht dran Nachricht", " &cDu bist gerade nicht dran!");
            fm.addConfigText("Du bist dran Nachricht", " &aDu bist nun dran!");
            fm.addConfigText("Du bist Fertig Nachricht", " &7Du bist nun fertig. Andere Spieler können nun ihren Schlag machen.");
            fm.addConfigText("Global Treffer Nachricht", " &a%s &7hat getroffen!");
            fm.addConfigText("Golf Nachricht", " §7Jeder Spieler bekommt einen Ball und darf nacheinander spielen. Um den Ball am Anfang werfen zu können, musst du dich auf die Eisendruckplatte stellen!");
            fm.saveConfig("MESSAGES");
        }
    }
}
