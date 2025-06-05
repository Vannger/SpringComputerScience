package MVCEducation;

import com.example.springEducation.Gun;
import com.example.springEducation.GunDisplayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CalculatorController {

    @Autowired
    private GunDisplayer gunDisplayer;

    @GetMapping("/calc")
    public String showFilterForm(Model model) {
        model.addAttribute("minCaliber", 0);
        model.addAttribute("maxCaliber", 1500);
        return "calc";
    }

    @GetMapping("/calc/filter")
    public String filterGuns(
            @RequestParam int minCaliber,
            @RequestParam int maxCaliber,
            Model model) {
        if (minCaliber < 0 || maxCaliber < minCaliber) {
            model.addAttribute("errorMessage", "Некорректный диапазон калибра");
            return "error";
        }

        List<Gun> filteredGuns = gunDisplayer.getGuns().stream()
                .filter(gun -> gun.getCaliber() >= minCaliber && gun.getCaliber() <= maxCaliber)
                .collect(Collectors.toList());

        model.addAttribute("guns", filteredGuns);
        model.addAttribute("minCaliber", minCaliber);
        model.addAttribute("maxCaliber", maxCaliber);
        return "calc-result";
    }
}
