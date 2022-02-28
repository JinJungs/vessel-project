package hem.vessel.controller;

import com.google.gson.Gson;
import hem.vessel.dto.VesselCompanyDto;
import hem.vessel.service.crawl.CrawlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
public class VesselController {

    @Autowired
    CrawlService crawlService;

    @GetMapping("/vessel")
    public ModelAndView toVessel(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("vessel");

//        try {
//            crawlService.test2();
//        }catch (IOException e){
//            e.printStackTrace();
//        }

        return mv;
    }

    @ResponseBody
    @PostMapping("/selectByVessel")
    public String selectByVessel(){
        String result = "";

        try {
            List<VesselCompanyDto> companyList = crawlService.test2();
            Gson gson = new Gson();
            result = gson.toJson(companyList);
        }catch (IOException e) {
            e.printStackTrace();
        }

        return result;

    }

}
