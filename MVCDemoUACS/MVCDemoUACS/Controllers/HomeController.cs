using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace MVCDemoUACS.Controllers
{
    public class HomeController : Controller
    {
        public ActionResult Index()
        {
            ViewData["Names"] = new List<string>()
            {
                "Igor",
                "Ana Marija",
                "Predrag",
                "Nikola"
            };
            
            return View();
        }
    }
}