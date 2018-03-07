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
    public partial class AddInfo : System.Web.UI.Page
    {
        public static string connectionString = "server=localhost;user id=root;password=root;persistsecurityinfo=True;database=lab4";

        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void TextBox1_TextChanged(object sender, EventArgs e)
        {

        }

        protected void TextBox2_TextChanged(object sender, EventArgs e)
        {

        }

        protected void TextBox3_TextChanged(object sender, EventArgs e)
        {

        }

        protected void TextBox4_TextChanged(object sender, EventArgs e)
        {

        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            try
            {
                if((TextBox1.Text.Length < 1) || (TextBox2.Text.Length < 1)||(TextBox3.Text.Length < 1)||(TextBox4.Text.Length < 1))
                {
                    Label5.Text = "Fill in the required fields.";
                }
                MySqlConnection con = new MySqlConnection(connectionString);
                con.Open();
                MySqlCommand cmd = new MySqlCommand("INSERT INTO users_info (Email, DOB, AboutME) VALUES ('" + TextBox2.Text + "','" + TextBox3.Text + "','" + TextBox4.Text + "')", con);
                cmd.ExecuteNonQuery();

                con.Close();
            }

            catch (Exception exp)
            {
                Label5.Text = "Email Does not exist";
            }
        }

        protected void Button2_Click(object sender, EventArgs e)
        {
            Response.Redirect("~/Login.aspx");
        }
    }
}