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
            TempData["tempID"] = id;
            TempData.Keep();
            return View(employees); 
        }

        [HttpGet]
        public ActionResult Create()      
        {
            ViewBag.tempID = (int)TempData["tempID"];
            return View();
        }

        [HttpPost]
        public ActionResult Create(Employee employee, int id)
        {
            if (ModelState.IsValid)
            {
                EmployeeContext employeeContext = new EmployeeContext();
                employee.DepartmentID = id;
                employeeContext.Employees.Add(employee);
                employeeContext.SaveChanges();

                return RedirectToAction("Index", new { id = id });
            }


            return View(employee);
        }

        [HttpGet]
        public ActionResult Edit(int id)
        {
            EmployeeContext employeeContext = new EmployeeContext();
            return View(employeeContext.Employees.Single(emp => emp.ID == id));
        }

        [HttpPost]
        public ActionResult Edit(Employee employee)
        {
            if (ModelState.IsValid)
            {
                EmployeeContext employeeContext = new EmployeeContext();
                employeeContext.Employees.Attach(employee);
                employeeContext.Entry(employee).State = System.Data.Entity.EntityState.Modified;
                employeeContext.SaveChanges();

                return RedirectToAction("Details", new { id = employee.ID });
            }

            return View(employee);
        }

        public ActionResult GetAll()
        {
            EmployeeContext employeeContext = new EmployeeContext();
            List<Employee> employees = employeeContext.Employees.ToList();
            return View(employees);
        }

    }
}