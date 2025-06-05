package MVCEducation;

import com.example.springEducation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import java.util.List;
import java.util.ArrayList;

@Configuration
public class AppConfig {


    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        return new HiddenHttpMethodFilter();
    }
    @Bean
    public List<Manufacturer> manufacturers() {
        List<Manufacturer> manufacturers = new ArrayList<>();
        manufacturers.add(new Manufacturer("Glock"));
        manufacturers.add(new Manufacturer("Smith & Wesson"));
        manufacturers.add(new Manufacturer("Remington"));
        manufacturers.add(new Manufacturer("Barrett"));
        return manufacturers;
    }

    @Bean
    public Gun pistol() {
        return new Pistol(1, "Glock 17", "Glock", 9);
    }

    @Bean
    public Gun rifle() {
        return new Rifle(2, "M4A1", "Remington", 5);
    }

    @Bean
    public GunDisplayer gunDisplayer() {
        List<Gun> guns = new ArrayList<>();
        guns.add(new Pistol(1, "Glock 17", "Glock", 9));
        guns.add(new Pistol(2, "Model 686", "Smith & Wesson", 357));
        guns.add(new Shotgun(3, "870 Express", "Remington", 12));
        guns.add(new Rifle(4, "M4A1", "Remington", 5));
        guns.add(new Shotgun(5, "Model 870 Tactical", "Remington", 12));
        guns.add(new Sniper(6, "M82", "Barrett", 50));
        return new GunDisplayer(guns);
    }
}
