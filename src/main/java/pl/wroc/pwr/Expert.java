package pl.wroc.pwr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Pawel on 04.01.14.
 */
@Service
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Expert {

    @Autowired
    private Knowledge knowledge;

    public List<Car> resolve(List<Answer> answers) {
        return null;
    }
}
