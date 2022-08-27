package com.biddingya.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.biddingya.beans.BulkEmail;
import com.biddingya.beans.Car;
import com.biddingya.beans.CarBidding;
import com.biddingya.beans.User;
import com.biddingya.security.ApplicationUserDetail;
import com.biddingya.service.BiddingyaService;
@Controller
public class BiddingyaController {
	private static Logger logger = LoggerFactory.getLogger(BiddingyaController.class);
	@Autowired
	BiddingyaService myservice;
	private HttpServletRequest authentication;
	
//	Home Page
	@GetMapping(value = "/")
	public String myHomePage() {
		return "Home";		
	}
//about us
	@GetMapping(value = "/about")
	public String about() {
		return "About";
	}
//Contact
	@GetMapping(value = "/contact")
	public String contact() {
		return "Contact";
	}
//Login Page
	@GetMapping(value = "/login")
	public String loginpage() {		
		return "Login";
	}	
	
//failed login 
	@GetMapping("/login_error")
	public String loginerror(Model model) {
		String error_msg = "Incorrect Username or Password";
		model.addAttribute("error_string", error_msg);
		return "Login";
	}
	
//emailconfirmation Page
	@GetMapping(value = "/emailvalidation")
	public String EmailConfirmation() {
		return "EmailConfirmation";
	}
//forget password code page
	@GetMapping(value = "/verifcode")
	public String forgetPasswordCode() {
		return "ForgetPasswordCode";
	}
//forget password email 
	@GetMapping(value = "/verifemail")
	public String forgetPasswordEmail() {
		return "ForgetPasswordEmail";
	}
//forget password
	@GetMapping(value = "/forgotpassword")
	public String forgotPassword(@ModelAttribute("data")User user) {
		return "ForgotPassword";
	}
//Register page
	@GetMapping(value = "/register")
	public String myRegisterPage(@ModelAttribute("vajresh") User us) {
		return "Registration";
		
	}
	@PostMapping(value = "/myreg")
	public String addRegisterPage(@ModelAttribute("vajresh") User us, @RequestParam String email, ModelMap map) {
		myservice.addUser(us);
		System.out.println(us);
		map.addAttribute("emailval", email);
		return "Thankyou";
	}
//	@PostMapping(value="/register")
//	public void registerUsers(@RequestBody User user) {
//		myservice.addUser(user);
//	}

//Admin Page
	@GetMapping(value = "/admin")
	public ModelAndView myadminPage() {
		List<User> Udata=myservice.showAll();
		System.out.println(Udata);
		return new ModelAndView("Adminpage","testv",Udata);
	}
//public profile page
	@GetMapping(value = "/user")
	public String myuserPage(HttpSession ses, @AuthenticationPrincipal ApplicationUserDetail appDetail) {
		String username = appDetail.getUsername();
		User user = myservice.ulogin(username);
		ses.setAttribute("userid", user.getUserid());
		ses.setAttribute("username", user.getUsername());
		ses.setAttribute("firstname", user.getFirstname());
		ses.setAttribute("lastname", user.getLastname());
		ses.setAttribute("email", user.getEmail());
		ses.setAttribute("contact", user.getContact());
		ses.setAttribute("country", user.getCountry());

		return "PublicProfile";
	
	}	
//public profile admin page
	@GetMapping(value = "/ppadmin")
	public String myadminPage(HttpSession ses, @AuthenticationPrincipal ApplicationUserDetail appDetail) {
		String username = appDetail.getUsername();
		User user = myservice.ulogin(username);
		ses.setAttribute("userid", user.getUserid());
		ses.setAttribute("username", user.getUsername());
		ses.setAttribute("firstname", user.getFirstname());
		ses.setAttribute("lastname", user.getLastname());
		ses.setAttribute("email", user.getEmail());
		ses.setAttribute("contact", user.getContact());
		ses.setAttribute("country", user.getCountry());
		return "PublicProfile-Admin";
		}	
//	Update Profile Page
	@GetMapping(value = "/updateProfile/{userid}")
	public ModelAndView updateProfile(@PathVariable("userid")Integer userid) {
		User user=myservice.searchUser(userid);
		return new ModelAndView("UpdateProfile","updt", user);
	}
	@GetMapping(value = "/updateProfile/updateprofile")
	public String updateprodata(@RequestParam("userid")Integer userid,
	@RequestParam("username")String username,
	@RequestParam("firstname")String firstname,
	@RequestParam("lastname")String lastname,		
	@RequestParam("email")String email,
	@RequestParam("role")String role,
	@RequestParam("contact")String contact,
	@RequestParam("country")String country,
	@RequestParam("password")String password) {
		
		System.out.println("success");
		User user = new User(userid, username, firstname, lastname, email,role, contact, country, password);
		myservice.updtUser(user);
		return "redirect:/user";
	}
	
//	Update Profile admin Page
	@GetMapping(value = "/updateProfile-admin/{userid}")
	public ModelAndView updateProfileadmin(@PathVariable("userid")Integer userid) {
		User user=myservice.searchUser(userid);
		return new ModelAndView("UpdateProfile-Admin","updt", user);
	}
	@GetMapping(value = "/updateProfile-admin/updateprofile-admin")
	public String updateprodata1(@RequestParam("userid")Integer userid,
	@RequestParam("username")String username,
	@RequestParam("firstname")String firstname,
	@RequestParam("lastname")String lastname,		
	@RequestParam("email")String email,
	@RequestParam("role")String role,
	@RequestParam("contact")String contact,
	@RequestParam("country")String country,
	@RequestParam("password")String password) {
		
		System.out.println("success");
		User user = new User(userid, username, firstname, lastname, email,role, contact, country, password);
		myservice.updtUser(user);
		return "redirect:/ppadmin";
	}
	
//update-user Page
		@GetMapping(value = "/updateUser/{userid}")
		public ModelAndView update(@PathVariable("userid")Integer userid) {
			User user=myservice.searchUser(userid);
			return new ModelAndView("Update-User","updt", user);
		}
		
		@GetMapping(value = "/updateUser/update")
		public String updatedata(@RequestParam("userid")Integer userid,
		@RequestParam("username")String username,
		@RequestParam("firstname")String firstname,
		@RequestParam("lastname")String lastname,		
		@RequestParam("email")String email,
		@RequestParam("role")String role,
		@RequestParam("contact")String contact,
		@RequestParam("country")String country,
		@RequestParam("password")String password) {
			
			System.out.println("success");
			User user = new User(userid, username, firstname, lastname, email,role, contact, country, password);
			myservice.updtUser(user);
			
			return "redirect:/admin";
		}
	@GetMapping("/deleteUser/{id}")
				public String deleteuser(@PathVariable(value = "id") Integer userid) {
					this.myservice.deleteUserData(userid);
					return "redirect:/admin";
				}
//search page		
	@GetMapping(value = "/search")
	public String search(@ModelAttribute("searchu")User username) {
			return "Search";
	}
	
//search page admin		
	@GetMapping(value = "/search-admin")
	public String searchadmin(@ModelAttribute("searchu")User username) {
		return "Search-Admin";
		}
//search result page
	@PostMapping(value = "/searchus")
	public ModelAndView SearchUser(@ModelAttribute("searchu") User username) {
		String searchname = username.getUsername();
		List<User> UU=myservice.showuser(searchname);
		return new ModelAndView("SearchResult","searchu",UU);
	}
//search result page admin
	@PostMapping(value = "/searchusadmin")
	public ModelAndView SearchUserAdmin(@ModelAttribute("searchu") User username) {
		String searchname = username.getUsername();
		List<User> UU=myservice.showuser(searchname);
		return new ModelAndView("SearchResult-Admin","searchu",UU);
	}

//search car page admin		
	@GetMapping(value = "/searchcar-admin")
	public String searchcaradmin(@ModelAttribute("searchcar")Car carModel) {
		return "SearchCar-Admin";
		}
//search car result page admin
	@PostMapping(value = "/searchcaradmin")
	public ModelAndView SearchCarAdmin(@ModelAttribute("searchcar") Car carModel) {
		String searchcarmodel = carModel.getCarModel();
		List<Car> UU=myservice.showcar(searchcarmodel);
		return new ModelAndView("SearchCarResult-Admin","searchcar",UU);
	}
//search car 
	@GetMapping(value = "/searchcar")
	public String searchcar(@ModelAttribute("searchcar")Car carModel) {
		return "SearchCar";
		}
//search car result page
	@PostMapping(value = "/searchcars")
	public ModelAndView SearchCar(@ModelAttribute("searchcar") Car carModel) {
		String searchcarmodel = carModel.getCarModel();
		List<Car> UU=myservice.showcar(searchcarmodel);
		System.out.println(searchcarmodel);
		System.out.println(UU);
		return new ModelAndView("SearchCarResult","searchcar",UU);
	}
///postcar
	@GetMapping(value = "/postcar")
	public String getpostcar(@ModelAttribute("car") Car cars) {
		return "PostCar";
	}
	
	@PostMapping(value = "/viewcar")
	public String viewcaradmin(@ModelAttribute("car")Car cars) {
		myservice.addCar(cars);
		System.out.println("ye");
		return "redirect:/viewcar";
	}

	
//viewcaradmin
	
	@GetMapping(value = "/viewcaradmin")
	public ModelAndView viewcaradmin() {
		List<Car> carData=myservice.showCars();
		System.out.println(carData);
		return new ModelAndView("ViewCar-Admin","viewcar",carData);
	}


//viewcaruser
	@GetMapping(value = "/viewcar")
	public ModelAndView viewcar() {
		List<Car> carData=myservice.showCars();
		System.out.println(carData);
		return new ModelAndView("ViewCar","viewcar",carData);
	}

//delete-car Page
	@GetMapping("/deleteCar/{carId}")
		public String deleteCar(@PathVariable(value = "carId") Integer carId) {
		this.myservice.deleteCarData(carId);
		return "redirect:/viewcaradmin";
				}

//Update-Car 
	@GetMapping(value = "/updateCar/{carId}")
	public ModelAndView Update(@PathVariable("carId")Integer carId, @ModelAttribute("updateCar") Car cars) {
		Car car=myservice.searchCar(carId);
		return new ModelAndView("Update-Car","updt", car);
	}
	@PostMapping(value= "updateCar/update")
	public String updatecardata(@ModelAttribute("updateCar") Car cars) {
		System.out.println("blm");
		myservice.updtCar(cars);
		System.out.println("sudah");
		return "redirect:/viewcaradmin";
	}
	
//bidding post
	@GetMapping(value = "/carbidding")
	public String getpostbidding(@RequestParam int carId, @ModelAttribute("carbidding") CarBidding carbidding, Model model) {
		Car car = myservice.uCar(carId);
		model.addAttribute("carId",car.getCarId());
		System.out.println(car);
		return "CarBidding";
	}
	
	@PostMapping(value = "/sendcarbidding")
	public String viewbidder(@ModelAttribute("carbidding")CarBidding carbidding) {
		myservice.addBidding(carbidding);
		System.out.println("ye");
		return "redirect:/viewcar";
	}
//list car bidding
	@GetMapping(value = "/viewcarbidding")
	public ModelAndView viewcarbidding(@RequestParam int carId, Model model) {
		Car car = myservice.uCar(carId);
		model.addAttribute("carId",car.getCarId());
		System.out.println(car);
		System.out.println(carId);
		List<CarBidding> carBiddingData=myservice.showBidding(carId);
		System.out.println(carBiddingData);
		return new ModelAndView("ListCarBidding","viewcarbidding",carBiddingData);
	}
//viewcarresult
		@GetMapping(value = "/viewcarresult/{carId}")
		public ModelAndView viewcarresult(@PathVariable("carId")Integer id) {
			Car car = myservice.uCar(id);
			return new ModelAndView("ViewCarResult","car",car);
		}

//viewcarresultadmin
	@GetMapping(value = "/viewcarresultadmin/{carId}")
	public ModelAndView viewcarresultadmin(@PathVariable("carId")Integer id) {
		Car car = myservice.uCar(id);
		return new ModelAndView("ViewCarResult-Admin","car",car);
	}
//Bulk Email 
		@GetMapping(value = "/bulkemail")
		public String bulkemail(@ModelAttribute("bulkemail") BulkEmail bulkemail) {
			return "BulkEmail";
		}
		
		@PostMapping(value = "/sendbulkemail")
		public String SendBulk(@ModelAttribute("bulkemail") BulkEmail bulkemail) {
			String to=(String) bulkemail.getRecipients();
			String[] receivers=to.split(", ");
			
			for(int i = 0; i < receivers.length; i++) {
				BulkEmail sendEmail = new BulkEmail();
				sendEmail.setRecipients(receivers[i]);
				sendEmail.setSubject(bulkemail.getSubject());
				sendEmail.setEmailMessages(bulkemail.getEmailMessages());
				
				myservice.addBulkEmail(sendEmail);
				myservice.sendBulkEmail(receivers[i], sendEmail.getSubject(), sendEmail.getEmailMessages());
				myservice.saveBulk(bulkemail);
			}
			return "redirect:/resultBulkEmail";
		}

//List bulk email
		
		@GetMapping(value = "/resultBulkEmail")
		public ModelAndView ListBulkEmail() {
			List<BulkEmail> EmailData=myservice.showBulkEmail();
			System.out.println(EmailData);
			return new ModelAndView("ListBulkEmail","bulkemail",EmailData);
		}

//accessDenied 
		@GetMapping("/AccessDenied")
		public ModelAndView error403() {
			ModelAndView model = new ModelAndView();
			model.setViewName("AccessDenied");
			return model;
		}

	



}
