package MVCEducation;

import com.example.springEducation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.logging.Logger;

@Controller
public class SimpleController {

    private static final Logger logger = Logger.getLogger(SimpleController.class.getName());

    @Autowired
    private List<Manufacturer> manufacturers;

    @Autowired
    private GunDisplayer gunDisplayer;

    @GetMapping("/guns")
    public String showGuns(
            @RequestParam(required = false, defaultValue = "0") int minCaliber,
            @RequestParam(required = false, defaultValue = "1500") int maxCaliber,
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
        return "gun-list";
    }

    @GetMapping("/gun")
    public String showGunById(@RequestParam int id, Model model) {
        logger.info("Запрос оружия с ID: " + id);
        Gun gun = gunDisplayer.getGuns().stream()
                .filter(g -> g.getId() == id)
                .findFirst()
                .orElse(null);
        if (gun == null) {
            logger.warning("Оружие с ID " + id + " не найдено");
            model.addAttribute("errorMessage", "Оружие с ID " + id + " не найдено");
            return "error";
        }
        model.addAttribute("gun", gun);
        return "gun-detail";
    }

    @GetMapping("/add-gun")
    public String showAddGunForm(Model model) {
        model.addAttribute("manufacturers", manufacturers);
        return "add-gun";
    }

    @PostMapping("/add-gun")
    public String addGun(
            @RequestParam String type,
            @RequestParam String modelName,
            @RequestParam String manufacturer,
            @RequestParam int caliber,
            Model model) {
        if (manufacturers.stream().noneMatch(m -> m.getManufacturer().equals(manufacturer))) {
            model.addAttribute("errorMessage", "Производитель не найден");
            return "error";
        }

        int newId = gunDisplayer.getGuns().stream()
                .mapToInt(Gun::getId)
                .max()
                .orElse(0) + 1;

        Gun newGun;
        switch (type) {
            case "Pistol":
                newGun = new Pistol(newId, modelName, manufacturer, caliber);
                break;
            case "Rifle":
                newGun = new Rifle(newId, modelName, manufacturer, caliber);
                break;
            case "Shotgun":
                newGun = new Shotgun(newId, modelName, manufacturer, caliber);
                break;
            case "Sniper":
                newGun = new Sniper(newId, modelName, manufacturer, caliber);
                break;
            default:
                model.addAttribute("errorMessage", "Некорректный тип оружия");
                return "error";
        }

        gunDisplayer.getGuns().add(newGun);
        logger.info("Добавлено оружие с ID: " + newId);
        return "redirect:/guns";
    }

    @GetMapping("/edit-gun")
    public String showEditGunForm(@RequestParam int id, Model model) {
        logger.info("Запрос редактирования оружия с ID: " + id);
        Gun gun = gunDisplayer.getGuns().stream()
                .filter(g -> g.getId() == id)
                .findFirst()
                .orElse(null);
        if (gun == null) {
            logger.warning("Оружие с ID " + id + " не найдено");
            model.addAttribute("errorMessage", "Оружие с ID " + id + " не найдено");
            return "error";
        }
        model.addAttribute("gun", gun);
        model.addAttribute("manufacturers", manufacturers);
        return "edit-gun";
    }

    @PostMapping("/edit-gun")
    public String editGun(
            @RequestParam int id,
            @RequestParam String type,
            @RequestParam String modelName,
            @RequestParam String manufacturer,
            @RequestParam int caliber,
            Model model) {
        if (manufacturers.stream().noneMatch(m -> m.getManufacturer().equals(manufacturer))) {
            model.addAttribute("errorMessage", "Производитель не найден");
            return "error";
        }

        Gun newGun;
        switch (type) {
            case "Pistol":
                newGun = new Pistol(id, modelName, manufacturer, caliber);
                break;
            case "Rifle":
                newGun = new Rifle(id, modelName, manufacturer, caliber);
                break;
            case "Shotgun":
                newGun = new Shotgun(id, modelName, manufacturer, caliber);
                break;
            case "Sniper":
                newGun = new Sniper(id, modelName, manufacturer, caliber);
                break;
            default:
                model.addAttribute("errorMessage", "Некорректный тип оружия");
                return "error";
        }

        gunDisplayer.getGuns().removeIf(g -> g.getId() == id);
        gunDisplayer.getGuns().add(newGun);
        logger.info("Отредактировано оружие с ID: " + id);
        return "redirect:/guns";
    }

    @GetMapping("/delete-gun")
    public String deleteGun(@RequestParam int id, Model model) {
        logger.info("Запрос удаления оружия с ID: " + id);
        boolean removed = gunDisplayer.getGuns().removeIf(g -> g.getId() == id);
        if (!removed) {
            logger.warning("Оружие с ID " + id + " не найдено");
            model.addAttribute("errorMessage", "Оружие с ID " + id + " не найдено");
            return "error";
        }
        logger.info("Удалено оружие с ID: " + id);
        return "redirect:/guns";
    }
}
