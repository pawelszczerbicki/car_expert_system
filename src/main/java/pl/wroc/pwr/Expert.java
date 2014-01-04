package pl.wroc.pwr;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

/**
 * Created by Pawel on 04.01.14.
 */
@Service
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Expert {
    //TODO making decisions, online in real time, and refuse cars with no criteria ex suv;

//    private static Map<Feature, String> answer = new HashMap<>();

}
