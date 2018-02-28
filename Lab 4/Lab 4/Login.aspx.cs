using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using MySql.Data;
using MySql.Data.MySqlClient;

namespace Lab_4
{
    public partial class Login : System.Web.UI.Page
    {
        public static string connectionString = "server=localhost;user id=root;password=root;persistsecurityinfo=True;database=lab4";
        public static string userID = "";
        public static string userType = "";

        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void typeBox_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        protected void login_btn_Click(object sender, EventArgs e)
        {
            try
            {
                if (emailBox.Text.Length < 4 || passwordBox.Text.Length < 3)
                {
                    ErrorBox.Text = "Email or password incorrect.";
                    return;
                }
                MySqlConnection con = new MySqlConnection(connectionString);
                con.Open();
                MySqlCommand cmd = new MySqlCommand("SELECT Pass FROM users WHERE Email=\"" + emailBox.Text + "\"", con);
                if (passwordBox.Text == cmd.ExecuteScalar().ToString())
                {
                    cmd = new MySqlCommand("SELECT UID FROM users WHERE Email=\"" + emailBox.Text + "\"", con);
                    userID = cmd.ExecuteScalar().ToString();
                    cmd = new MySqlCommand("SELECT UType FROM users WHERE Email=\"" + emailBox.Text + "\"", con);
                    userType = cmd.ExecuteScalar().ToString();
                    if (userType == "User")
                        Response.Redirect("~/AddInfo.aspx");
                    else if (userType == "Admin")
                        Response.Redirect("~/Admin.aspx");
                }
                else
                    ErrorBox.Text = "Incorrect email or password";
                con.Close();
            }
            catch (Exception exp)
            {
                ErrorBox.Text = "Email Does not exist";
            }
        }

        protected void passwordBox_TextChanged(object sender, EventArgs e)
        {

        }

        protected void emailBox_TextChanged(object sender, EventArgs e)
        {

        }

        protected void register_btn_Click(object sender, EventArgs e)
        {

        }
    }
}