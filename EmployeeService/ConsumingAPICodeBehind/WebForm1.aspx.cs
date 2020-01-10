using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Text;
using System.Web;
using System.Web.Script.Serialization;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace ConsumingAPICodeBehind
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!this.IsPostBack)
            {
                this.PopulateGridView();
            }
        }

        protected void Search(object sender, EventArgs e)
        {
            this.PopulateGridView();
        }

        private void PopulateGridView()
        {
            string apiUrl = "https://localhost:44368/api/employees";
            object input = new
            {
               // Name = txtName.Text.Trim(),
            };
            string inputJson = (new JavaScriptSerializer()).Serialize(input);
            WebClient client = new WebClient();
            client.Headers["Content-type"] = "application/json";
            client.Encoding = Encoding.UTF8;

            string json = client.DownloadString(apiUrl);

            gvCustomers.DataSource = (new JavaScriptSerializer()).Deserialize<List<Employee>>(json);
            gvCustomers.DataBind();
        }

        public class Employee
        {
            public string FirstName { get; set; }
            public string LastName { get; set; }
            public string Salary { get; set; }

            public string Gender { get; set; }
            public int ID { get; set; }
        }
    }
}