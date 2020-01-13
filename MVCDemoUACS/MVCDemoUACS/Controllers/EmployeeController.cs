using MVCDemoUACS.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace MVCDemoUACS.Controllers
{
    public class EmployeeController : Controller
    {
        // GET: Employee
        public ActionResult Details(int id)
        {
            EmployeeContext employeeContext = new EmployeeContext(); 
            Employee employee = employeeContext.Employees.Single(x => x.ID == id);

            return View(employee);
        }

        public ActionResult Index(int id)        
        { 
            EmployeeContext employeeContext = new EmployeeContext();
            List<Employee> employees = employeeContext.Employees.Where(x => x.DepartmentID == id).ToList();
            return View(employees); 
        }
    }
}