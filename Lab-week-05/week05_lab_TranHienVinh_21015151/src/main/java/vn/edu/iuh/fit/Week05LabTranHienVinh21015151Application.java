package vn.edu.iuh.fit;

import com.neovisionaries.i18n.CountryCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.backend.models.*;
import vn.edu.iuh.fit.backend.repositories.AddressRepository;
import vn.edu.iuh.fit.backend.repositories.CandidateRepository;
import vn.edu.iuh.fit.backend.repositories.CompanyRepository;
import vn.edu.iuh.fit.backend.repositories.SkillRepository;
import vn.edu.iuh.fit.backend.services.JobService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class Week05LabTranHienVinh21015151Application {

    public static void main(String[] args) {
        SpringApplication.run(Week05LabTranHienVinh21015151Application.class, args);
    }
//    @Autowired
//    private CandidateRepository candidateRepository;
//    @Autowired
//    private AddressRepository addressRepository;
//    @Autowired
//    private CompanyRepository companyRepository;
//    @Autowired
//    private SkillRepository skillRepository;
//    @Autowired
//    private JobService jobService;
//    @Bean
//    CommandLineRunner initData(){
//        return args -> {
//            Random rnd = new Random();
//            List<Long> usedAddressIds = new ArrayList<>();
//            int maxAddressId = 1000; // Giả sử bạn có 10 địa chỉ trong cơ sở dữ liệu
//
//            for (int i = 1; i < 100; i++) {
//                // Tìm một địa chỉ ngẫu nhiên mà chưa được chọn
//                Long addressId;
//                Address add;
//                do {
//                    addressId = (long) rnd.nextInt(maxAddressId) + 1;
//                    add = addressRepository.findById(addressId).orElse(null);
//                } while (add == null || usedAddressIds.contains(addressId));
//                usedAddressIds.add(addressId);
//
//                // Tạo đối tượng Company mới
//                Company company = new Company();
//                String companyName = "Company " + i;
//                String companyEmail = "company" + i + "@gmail.com";
//
//                // Kiểm tra xem Company với tên hoặc email đã tồn tại hay chưa
//                boolean companyExists = companyRepository.existsByCompNameOrEmail(companyName, companyEmail);
//                if (companyExists) {
//                    continue; // Nếu tồn tại, bỏ qua vòng lặp này và tạo Company khác
//                }
//
//                // Thiết lập thông tin cho Company
//                company.setAbout("About company " + i);
//                company.setAddress(add);
//                company.setCompName(companyName);
//                company.setEmail(companyEmail);
//                company.setPhone("09000000" + i);
//                company.setWebUrl("http://company" + i + ".com");
//
//                // Lưu Company vào cơ sở dữ liệu
//                companyRepository.save(company);
//            }
////             Tạo 10 Skill với ngôn ngữ lập trình
//            String[] programmingLanguages = {"Java", "Python", "JavaScript", "C++", "C#", "Ruby", "Go", "Swift", "Kotlin", "PHP"};
//            byte type = 1;
//
//            for (int i = 0; i < programmingLanguages.length; i++) {
//                Skill skill = new Skill();
//                skill.setSkillName(programmingLanguages[i]);
//                skill.setSkillDescription("A programming language used for development of software.");
//                skill.setType(type);
//
//                // Lưu Skill vào cơ sở dữ liệu
//                skillRepository.save(skill);
//            }
//        };
//    }
}
