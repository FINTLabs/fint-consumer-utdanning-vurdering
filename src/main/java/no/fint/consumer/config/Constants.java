package no.fint.consumer.config;

public enum Constants {
;

    public static final String COMPONENT = "utdanning-vurdering";
    public static final String COMPONENT_CONSUMER = COMPONENT + " consumer";
    public static final String CACHE_SERVICE = "CACHE_SERVICE";

    
    public static final String CACHE_INITIALDELAY_ANMERKNINGER = "${fint.consumer.cache.initialDelay.anmerkninger:900000}";
    public static final String CACHE_FIXEDRATE_ANMERKNINGER = "${fint.consumer.cache.fixedRate.anmerkninger:900000}";
    
    public static final String CACHE_INITIALDELAY_EKSAMENSGRUPPE = "${fint.consumer.cache.initialDelay.eksamensgruppe:1000000}";
    public static final String CACHE_FIXEDRATE_EKSAMENSGRUPPE = "${fint.consumer.cache.fixedRate.eksamensgruppe:900000}";
    
    public static final String CACHE_INITIALDELAY_EKSAMENSGRUPPEMEDLEMSKAP = "${fint.consumer.cache.initialDelay.eksamensgruppemedlemskap:1100000}";
    public static final String CACHE_FIXEDRATE_EKSAMENSGRUPPEMEDLEMSKAP = "${fint.consumer.cache.fixedRate.eksamensgruppemedlemskap:900000}";

    //    public static final String CACHE_INITIALDELAY_ELEVFRAVAR = "${fint.consumer.cache.initialDelay.elevfravar:1200000}";
//    public static final String CACHE_FIXEDRATE_ELEVFRAVAR = "${fint.consumer.cache.fixedRate.elevfravar:900000}";
    public static final String CACHE_CRON_ELEVFRAVAR = "${fint.consumer.cache.cron.elevfravar:0 20 */2 * * *}";
    
    public static final String CACHE_INITIALDELAY_ELEVVURDERING = "${fint.consumer.cache.initialDelay.elevvurdering:1300000}";
    public static final String CACHE_FIXEDRATE_ELEVVURDERING = "${fint.consumer.cache.fixedRate.elevvurdering:900000}";

    //    public static final String CACHE_INITIALDELAY_FRAVAR = "${fint.consumer.cache.initialDelay.fravar:1300000}";
//    public static final String CACHE_FIXEDRATE_FRAVAR = "${fint.consumer.cache.fixedRate.fravar:900000}";
    public static final String CACHE_CRON_FRAVAR = "${fint.consumer.cache.cron.fravar:0 0 */2 * * *}";

    //    public static final String CACHE_INITIALDELAY_FRAVARSOVERSIKT = "${fint.consumer.cache.initialDelay.fravarsoversikt:1400000}";
//    public static final String CACHE_FIXEDRATE_FRAVARSOVERSIKT = "${fint.consumer.cache.fixedRate.fravarsoversikt:900000}";
    public static final String CACHE_CRON_FRAVARSOVERSIKT = "${fint.consumer.cache.cron.fravarsoversikt:0 10 */2 * * *}";

    //    public static final String CACHE_INITIALDELAY_FRAVARSREGISTRERING = "${fint.consumer.cache.initialDelay.fravarsregistrering:1500000}";
//    public static final String CACHE_FIXEDRATE_FRAVARSREGISTRERING = "${fint.consumer.cache.fixedRate.fravarsregistrering:900000}";
    public static final String CACHE_CRON_FRAVARSREGISTRERING = "${fint.consumer.cache.cron.fravarsregistrering:0 30 */2 * * *}";
    
    public static final String CACHE_INITIALDELAY_HALVARSFAGVURDERING = "${fint.consumer.cache.initialDelay.halvarsfagvurdering:1700000}";
    public static final String CACHE_FIXEDRATE_HALVARSFAGVURDERING = "${fint.consumer.cache.fixedRate.halvarsfagvurdering:900000}";
    
    public static final String CACHE_INITIALDELAY_HALVARSORDENSVURDERING = "${fint.consumer.cache.initialDelay.halvarsordensvurdering:1800000}";
    public static final String CACHE_FIXEDRATE_HALVARSORDENSVURDERING = "${fint.consumer.cache.fixedRate.halvarsordensvurdering:900000}";
    
    public static final String CACHE_INITIALDELAY_KARAKTERHISTORIE = "${fint.consumer.cache.initialDelay.karakterhistorie:1900000}";
    public static final String CACHE_FIXEDRATE_KARAKTERHISTORIE = "${fint.consumer.cache.fixedRate.karakterhistorie:900000}";
    
    public static final String CACHE_INITIALDELAY_KARAKTERVERDI = "${fint.consumer.cache.initialDelay.karakterverdi:2000000}";
    public static final String CACHE_FIXEDRATE_KARAKTERVERDI = "${fint.consumer.cache.fixedRate.karakterverdi:900000}";
    
    public static final String CACHE_INITIALDELAY_SENSOR = "${fint.consumer.cache.initialDelay.sensor:2100000}";
    public static final String CACHE_FIXEDRATE_SENSOR = "${fint.consumer.cache.fixedRate.sensor:900000}";
    
    public static final String CACHE_INITIALDELAY_SLUTTFAGVURDERING = "${fint.consumer.cache.initialDelay.sluttfagvurdering:2200000}";
    public static final String CACHE_FIXEDRATE_SLUTTFAGVURDERING = "${fint.consumer.cache.fixedRate.sluttfagvurdering:900000}";
    
    public static final String CACHE_INITIALDELAY_SLUTTORDENSVURDERING = "${fint.consumer.cache.initialDelay.sluttordensvurdering:2300000}";
    public static final String CACHE_FIXEDRATE_SLUTTORDENSVURDERING = "${fint.consumer.cache.fixedRate.sluttordensvurdering:900000}";
    
    public static final String CACHE_INITIALDELAY_UNDERVEISFAGVURDERING = "${fint.consumer.cache.initialDelay.underveisfagvurdering:2400000}";
    public static final String CACHE_FIXEDRATE_UNDERVEISFAGVURDERING = "${fint.consumer.cache.fixedRate.underveisfagvurdering:900000}";
    
    public static final String CACHE_INITIALDELAY_UNDERVEISORDENSVURDERING = "${fint.consumer.cache.initialDelay.underveisordensvurdering:2500000}";
    public static final String CACHE_FIXEDRATE_UNDERVEISORDENSVURDERING = "${fint.consumer.cache.fixedRate.underveisordensvurdering:900000}";
    
    public static final String CACHE_INITIALDELAY_VURDERING = "${fint.consumer.cache.initialDelay.vurdering:2600000}";
    public static final String CACHE_FIXEDRATE_VURDERING = "${fint.consumer.cache.fixedRate.vurdering:900000}";
    

}
