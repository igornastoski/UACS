using EmployeeService.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Web;
using System.Web.Mvc;

namespace EmployeeService.Controllers
{
    public class EmployeeMVCController : Controller
    {
        // GET: EmployeeMVC
        public ActionResult Index()
        {
            IEnumerable<EmployeeViewModel> employees = null;

            using (var client = new HttpClient())
            {
                client.BaseAddress = new Uri("https://localhost:44368/api/");
                //HTTP GET
                var responseTask = client.GetAsync("employees");
                responseTask.Wait();

                var result = responseTask.Result;
                if (result.IsSuccessStatusCode)
                {
                    var readTask = result.Content.ReadAsAsync<IList<EmployeeViewModel>>();
                    readTask.Wait();

                    employees = readTask.Result.OrderBy(t => t.Salary);
                }
                else //web api sent error response 
                {
                    //log response status here..

                    employees = Enumerable.Empty<EmployeeViewModel>();

                    ModelState.AddModelError(string.Empty, "Server error. Please contact administrator.");
                }
            }
            return View(employees);
        }
    }
}