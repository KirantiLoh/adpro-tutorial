package id.ac.ui.cs.advprog.eshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.service.CarServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarServiceImpl service;

    @GetMapping("/createCar")
    public String createCar(Model model) {
        Car car = new Car();
        model.addAttribute("car", car);
        return "CreateCar";
    }

    @PostMapping("/createCar")
    public String createCarPost(@ModelAttribute Car car, Model model) {
        service.create(car);
        return "redirect:list";
    }

    @GetMapping("/list")
    public String listCar(Model model) {
        List<Car> cars = service.findAll();
        model.addAttribute("cars", cars);
        return "CarList";
    }

    @GetMapping("/editCar/{id}")
    public String editCar(@PathVariable("id") String id, Model model) {
        Car car = service.findById(id);
        model.addAttribute("car", car);
        return "EditCar";
    }

    @PostMapping("/editCar")
    public String editCarPost(@ModelAttribute Car car, Model model) {
        service.update(car.getId(), car);
        return "redirect:list";
    }

    @PostMapping("/deleteCar")
    public String deleteCar(@RequestParam("id") String id, Model model) {
        service.delete(id);
        return "redirect:list";
    }
}
