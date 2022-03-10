package bdbt_project.SpringApplication;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Arrays;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@Configuration
public class AppController implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/userPanel").setViewName("userPanel");
        registry.addViewController("/buyService").setViewName("buyService");
        registry.addViewController("/addresses").setViewName("addresses");
        registry.addViewController("/clients").setViewName("clients");
        registry.addViewController("/baseStations").setViewName("baseStations");
        registry.addViewController("/antennas").setViewName("antennas");
        registry.addViewController("/details").setViewName("details");
    }

    @Autowired
    private AdresDAO adresDAO;
    @Autowired
    private OperatorDAO operatorDAO;
    @Autowired
    private KlientDAO klientDAO;
    @Autowired
    private OsobaPrywatnaDAO osobaPrywatnaDAO;
    @Autowired
    private UslugaDAO uslugaDAO;
    @Autowired
    private TransakcjaDAO transakcjaDAO;
    @Autowired
    private NumerTelefonuDAO numerTelefonuDAO;
    @Autowired
    private DaneFirmDAO daneFirmDAO;
    @Autowired
    private StacjaBazowaDAO stacjaBazowaDAO;
    @Autowired
    private AntenaDAO antenaDAO;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
    }

    @RequestMapping("/main")
    public String viewMain(Model model) {
        List<Transakcja> transakcjaList = transakcjaDAO.list();
        List<DaneFirm> daneFirmList = daneFirmDAO.list();
        List<OsobaPrywatna> osobaPrywatnaList = osobaPrywatnaDAO.list();
        List<Adres> adresList = adresDAO.list();
        List<Klient> klientList = klientDAO.list();
        Operator adminOperator = operatorDAO.get(1);
        Adres adres = new Adres();
        Klient klient = new Klient();
        model.addAttribute("klient", klient);
        model.addAttribute("adres", adres);
        model.addAttribute("adresList", adresList);
        model.addAttribute("adminOperator", adminOperator);
        model.addAttribute("klientList", klientList);
        model.addAttribute("daneFirmList", daneFirmList);
        model.addAttribute("osobaPrywatnaList", osobaPrywatnaList);
        model.addAttribute("osobaPrywatnaDAO", osobaPrywatnaDAO);
        model.addAttribute("daneFirmDAO", daneFirmDAO);
        model.addAttribute("transakcjaList", transakcjaList);
        model.addAttribute("uslugaDAO", uslugaDAO);
        return "/main";
    }

    @RequestMapping("/userPanel")
    public String viewUserPanel(Model model) {
        List<Transakcja> transakcjaList = transakcjaDAO.list();
        List<Usluga> uslugaList = uslugaDAO.list();
        Adres userAddress = adresDAO.get(8);
        Klient userData = klientDAO.get(21);
        OsobaPrywatna userDetails = osobaPrywatnaDAO.get(21);
        model.addAttribute("userData", userData);
        model.addAttribute("userAddress", userAddress);
        model.addAttribute("userDetails", userDetails);
        model.addAttribute("uslugaList", uslugaList);
        model.addAttribute("transakcjaDAO", transakcjaDAO);
        model.addAttribute("uslugaDAO", uslugaDAO);
        model.addAttribute("numerTelefonuDAO", numerTelefonuDAO);
        model.addAttribute("klientDAO", klientDAO);
        model.addAttribute("osobaPrywatnaDAO", osobaPrywatnaDAO);
        model.addAttribute("transakcjaList", transakcjaList);
        return "/userPanel";
    }

    @RequestMapping("/details")
    public String viewDetails(Model model) {
        List<Transakcja> transakcjaList = transakcjaDAO.getForClient(21);
        List<Usluga> uslugaList = uslugaDAO.list();
        Adres userAddress = adresDAO.get(8);
        Klient userData = klientDAO.get(21);
        OsobaPrywatna userDetails = osobaPrywatnaDAO.get(21);
        model.addAttribute("userData", userData);
        model.addAttribute("userAddress", userAddress);
        model.addAttribute("userDetails", userDetails);
        model.addAttribute("uslugaList", uslugaList);
        model.addAttribute("transakcjaDAO", transakcjaDAO);
        model.addAttribute("uslugaDAO", uslugaDAO);
        model.addAttribute("numerTelefonuDAO", numerTelefonuDAO);
        model.addAttribute("klientDAO", klientDAO);
        model.addAttribute("adresDAO", adresDAO);
        model.addAttribute("osobaPrywatnaDAO", osobaPrywatnaDAO);
        model.addAttribute("transakcjaList", transakcjaList);
        return "details";
    }

    @RequestMapping("/addresses")
    public String viewAddresses(Model model) {
        List<Adres> adresList = adresDAO.list();
        Operator adminOperator = operatorDAO.get(1);
        Adres adres = new Adres();
        model.addAttribute("adres", adres);
        model.addAttribute("adresList", adresList);
        model.addAttribute("adminOperator", adminOperator);
        return "addresses";
    }

    @RequestMapping("/clients")
    public String viewClients(Model model) {
        List<Adres> adresList = adresDAO.list();
        List<Klient> klientList = klientDAO.list();
        Operator adminOperator = operatorDAO.get(1);
        Klient klient = new Klient();
        model.addAttribute("klient", klient);
        model.addAttribute("adresList", adresList);
        model.addAttribute("adminOperator", adminOperator);
        model.addAttribute("klientList", klientList);
        model.addAttribute("osobaPrywatnaDAO", osobaPrywatnaDAO);
        model.addAttribute("adresDAO", adresDAO);
        return "clients";
    }

    @RequestMapping("/baseStations")
    public String viewBaseStations(Model model) {
        List<String> typStacjiList = Arrays.asList("Mikrokomorka", "Makrokomorka", "Megakomorka");
        List<StacjaBazowa> stacjaBazowaList = stacjaBazowaDAO.list();
        List<Adres> adresList = adresDAO.list();
        Operator adminOperator = operatorDAO.get(1);
        StacjaBazowa stacjaBazowa = new StacjaBazowa();
        stacjaBazowa.setId_operatora(1);
        model.addAttribute("adminOperator", adminOperator);
        model.addAttribute("stacjaBazowaList", stacjaBazowaList);
        model.addAttribute("stacjaBazowaDAO", stacjaBazowaDAO);
        model.addAttribute("stacjaBazowa", stacjaBazowa);
        model.addAttribute("adresDAO", adresDAO);
        model.addAttribute("adresList", adresList);
        model.addAttribute("typStacjiList", typStacjiList);
        return "baseStations";
    }

    @RequestMapping("/antennas")
    public String viewAntennas(Model model) {
        List<String> typStandarduList = Arrays.asList("5G", "4G", "3G", "GSM");
        List<StacjaBazowa> stacjaBazowaList = stacjaBazowaDAO.list();
        List<Antena> antenaList = antenaDAO.list();
        List<Adres> adresList = adresDAO.list();
        Operator adminOperator = operatorDAO.get(1);
        Adres adres = new Adres();
        Antena antena = new Antena();
        model.addAttribute("adres", adres);
        model.addAttribute("adresList", adresList);
        model.addAttribute("antena", antena);
        model.addAttribute("antenaList", antenaList);
        model.addAttribute("adminOperator", adminOperator);
        model.addAttribute("stacjaBazowaList", stacjaBazowaList);
        model.addAttribute("stacjaBazowaDAO", stacjaBazowaDAO);
        model.addAttribute("typStandarduList", typStandarduList);
        return "antennas";
    }

    @RequestMapping("/index")
    public String viewIndex(Model model) {
        Operator adminOperator = operatorDAO.get(1);
        model.addAttribute("adminOperator", adminOperator);
        return "index";
    }

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        /* Import java.util.List */
        List<Adres> adresList = adresDAO.list();
        Operator adminOperator = operatorDAO.get(1);
        model.addAttribute("adresList", adresList);
        model.addAttribute("adminOperator", adminOperator);
        return "index";
    }

    @RequestMapping(value = "/saveAddress", method = RequestMethod.POST)
    public String save(@ModelAttribute("adres") Adres adres) {
        adresDAO.save(adres);

        return "redirect:/addresses";
    }

    @RequestMapping(value = "/saveClient", method = RequestMethod.POST)
    public String save(@ModelAttribute("klient") Klient klient) throws java.text.ParseException {
        klientDAO.save(klient);
        return "redirect:/clients";
    }

    @RequestMapping(value = "/saveTransaction", method = RequestMethod.POST)
    public String save(@ModelAttribute("transakcja") Transakcja transakcja){
        transakcjaDAO.save(transakcja);
        return "redirect:/userPanel";
    }

    @RequestMapping(value = "/saveStation", method = RequestMethod.POST)
    public String save(@ModelAttribute("baseStation") StacjaBazowa stacjaBazowa){
        stacjaBazowaDAO.save(stacjaBazowa);
        return "redirect:/baseStations";
    }

    @RequestMapping(value = "/saveAntenna", method = RequestMethod.POST)
    public String save(@ModelAttribute("antenna") Antena antena){
        antenaDAO.save(antena);
        return "redirect:/antennas";
    }

    @RequestMapping("/buyService/{id}")
    public String showBuyServiceForm(@PathVariable(name = "id") int id, Model model) {
        Transakcja transakcja = new Transakcja();
        Usluga usluga = uslugaDAO.get(id);
        Klient klient = klientDAO.get(21);
        transakcja.setId_klienta(klient.getId_klienta());
        transakcja.setId_uslugi(usluga.getId_uslugi());
        model.addAttribute("usluga", usluga);
        model.addAttribute("klient", klient);
        model.addAttribute("transakcja", transakcja);
        return "buyService";
    }

    @RequestMapping("/editAddress/{id}")
    public String showEditForm(@PathVariable(name = "id") int id, Model model) {
        model.addAttribute("adres", adresDAO.get(id));
        model.addAttribute("newAddress", new Adres());
        return "editAddress_form";
    }

    @RequestMapping("/editClient/{id}")
    public ModelAndView showClientEdit(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("editClient");
        List<Adres> adresList = adresDAO.list();
        Klient klient = klientDAO.get(id);
        mav.addObject("klient", klient);
        mav.addObject("adresList", adresList);
        return mav;
    }

    @RequestMapping("/editCompanyData/{id}")
    public ModelAndView showCompanyDataEdit(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("editCompanyData");
        DaneFirm daneFirm = daneFirmDAO.get(id);
        mav.addObject("dane", daneFirm);
        return mav;
    }

    @RequestMapping("/editBaseStation/{id}")
    public ModelAndView showBaseStationEdit(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("editBaseStation");
        List<String> typStacjiList = Arrays.asList("Mikrokomorka", "Makrokomorka", "Megakomorka");
        List<Adres> adresList = adresDAO.list();
        StacjaBazowa stacjaBazowa = stacjaBazowaDAO.get(id);
        mav.addObject("stacjaBazowa", stacjaBazowa);
        mav.addObject("adresList", adresList);
        mav.addObject("typStacjiList", typStacjiList);
        return mav;
    }

    @RequestMapping("/editAntenna/{id}")
    public ModelAndView showAntennaEdit(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("editAntenna");
        List<String> typStandarduList = Arrays.asList("5G", "4G", "3G", "GSM");
        List<Adres> adresList = adresDAO.list();
        Antena antena = antenaDAO.get(id);
        List<StacjaBazowa> stacjaBazowaList = stacjaBazowaDAO.list();
        mav.addObject("antena", antena);
        mav.addObject("adresList", adresList);
        mav.addObject("typStandarduList", typStandarduList);
        mav.addObject("stacjaBazowaList", stacjaBazowaList);
        return mav;
    }

    @RequestMapping("/editService/{id}")
    public ModelAndView showServiceEdit(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("editService");
        Transakcja transakcja = transakcjaDAO.get(id);
        mav.addObject("klient", klientDAO.get(21));
        mav.addObject("uslugaDAO", uslugaDAO);
        mav.addObject("transakcja", transakcja);
        return mav;
    }

    @RequestMapping("/editData")
    public String showDataEdit(Model model){
        model.addAttribute("klient", klientDAO.get(21));
        model.addAttribute("klientData", osobaPrywatnaDAO.get(21));
        return "/editClient";
    }

    @RequestMapping(value = "/updateData", method = RequestMethod.POST)
    public String update(@ModelAttribute("klientData") OsobaPrywatna osobaPrywatna){
        osobaPrywatnaDAO.update(osobaPrywatna);
        return "redirect:/details";
    }

    @RequestMapping(value = "/updateAddress", method = RequestMethod.POST)
    public String update(@ModelAttribute("adres") Adres adres){
        adresDAO.update(adres);
        return "redirect:/addresses";
    }

    @RequestMapping(value = "/updateClient", method = RequestMethod.POST)
    public String update(@ModelAttribute("klient") Klient klient){
        klientDAO.update(klient);
        return "redirect:/clients";
    }

    @RequestMapping(value = "/updateCompanyData", method = RequestMethod.POST)
    public String update(@ModelAttribute("data") DaneFirm daneFirm){
        daneFirmDAO.update(daneFirm);
        return "redirect:/main";
    }

    @RequestMapping(value = "/updateBaseStation", method = RequestMethod.POST)
    public String update(@ModelAttribute("stacjaBazowa") StacjaBazowa stacjaBazowa){
        stacjaBazowaDAO.update(stacjaBazowa);
        return "redirect:/baseStations";
    }

    @RequestMapping(value = "/updateAntenna", method = RequestMethod.POST)
    public String update(@ModelAttribute("antenna") Antena antena){
        antenaDAO.update(antena);
        return "redirect:/antennas";
    }

    @RequestMapping(value = "/updateTransaction", method = RequestMethod.POST)
    public String update(@ModelAttribute("transakcja") Transakcja transakcja){
        transakcjaDAO.update(transakcja);
        return "redirect:/details";
    }

    @RequestMapping("/deleteAddress/{id}")
    public String deleteAddress(@PathVariable(name = "id") int id){
        adresDAO.delete(id);
        return "redirect:/addresses";
    }

    @RequestMapping("/deleteClient/{id}")
    public String deleteClient(@PathVariable(name = "id") int id){
        klientDAO.delete(id);
        return "redirect:/clients";
    }

    @RequestMapping("/deleteBaseStation/{id}")
    public String deleteBaseStation(@PathVariable(name = "id") int id){
        stacjaBazowaDAO.delete(id);
        return "redirect:/baseStations";
    }

    @RequestMapping("/deleteAntenna/{id}")
    public String deleteAntenna(@PathVariable(name = "id") int id){
        antenaDAO.delete(id);
        return "redirect:/antennas";
    }

    @RequestMapping("/deleteService/{id}")
    public String deleteService(@PathVariable(name = "id") int id){
        transakcjaDAO.delete(id);
        return "redirect:/details";
    }

    @ExceptionHandler({SQLException.class, SQLIntegrityConstraintViolationException.class})
    public String dataIntegrityConstraintViolEx(){
        return "dataIntegrityConstraintViolEx";
    }
}