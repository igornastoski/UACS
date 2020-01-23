using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace MVCDemoUACS.Models
{
    [Table("tblDepartment")] 
    public class Department { 
        public int ID { get; set; } 
        [Required(ErrorMessage = "Please enter the name.")]
        public string Name { get; set; } 
        public List<Employee> Employees { get; set; } 
    }
}