using MVCDemoUACS.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace MVCDemoUACS.Controllers
{
    public class DepartmentController : Controller
    {
        // GET: Department
        public ActionResult Index()
        {
            EmployeeContext employeeContext = new EmployeeContext(); 
            List<Department> departments = employeeContext.Departments.ToList(); 
            return View(departments);
        }

        [HttpGet]
        public ActionResult Create()
        {
            return View();
        }

        //[HttpPost]
        //public ActionResult Create(Department department)
        //{
        //    if (ModelState.IsValid)
        //    {
        //        EmployeeContext employeeContext = new EmployeeContext();
        //        employeeContext.Departments.Add(department);
        //        employeeContext.SaveChanges();

        //        return RedirectToAction("Index");
        //    }

        //    return View(department);
        //}

        //[HttpPost]
        //public ActionResult Create(string Name)
        //{
        //    Department department = new Department();
        //    department.Name = Name;

        //    EmployeeContext employeeContext = new EmployeeContext();
        //    employeeContext.Departments.Add(department);
        //    employeeContext.SaveChanges();
        //    return RedirectToAction("Index");
        //}

        //[HttpPost]
        //public ActionResult Create(FormCollection formCollection)
        //{
        //    Department department = new Department();
        //    department.Name = formCollection["Name"];

        //    EmployeeContext employeeContext = new EmployeeContext();
        //    employeeContext.Departments.Add(department);
        //    employeeContext.SaveChanges();
        //    return RedirectToAction("Index");
        //}

        [HttpPost]
        [ActionName("Create")]
        public ActionResult Create_Post()
        {
            if (ModelState.IsValid)
            {
                Department department = new Department();
                UpdateModel(department);

                EmployeeContext employeeContext = new EmployeeContext();
                employeeContext.Departments.Add(department);
                employeeContext.SaveChanges();

                return RedirectToAction("Index");
            }

            return View();
        }

        //[HandleError]
        public ActionResult GetError()
        {
            throw new Exception("Something went wrong");
        }
    }
}