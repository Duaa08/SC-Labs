using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using MySql.Data;
using MySql.Data.MySqlClient;
using System.Configuration;
using System.Data;

namespace Lab_4
{
    public partial class Admin : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            try
            {
                //DataTable dt = new DataTable();
                using (MySqlConnection conn = new MySqlConnection(WebForm1.connectionString))
                {
                    using (MySqlCommand cmd = new MySqlCommand("SELECT * FROM users_info"))
                    {
                        using (MySqlDataAdapter da = new MySqlDataAdapter())
                        {
                            cmd.Connection = conn;
                            da.SelectCommand = cmd;
                            using (DataTable dt11 = new DataTable())
                            {
                                da.Fill(dt11);
                                GridView1.DataSource = dt11;
                                GridView1.DataBind();
                            }
                        }
                    }
                }

            }

            catch (Exception exp)
            {

                //Err.Text = "No artifact of this author exists!";
            }
        }
    }
}