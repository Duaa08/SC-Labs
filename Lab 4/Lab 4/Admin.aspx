<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Admin.aspx.cs" Inherits="Lab_4.Admin" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <asp:Button ID="Button1" runat="server" OnClick="Button1_Click" Text="Show User Information" />
    <div>
    
    </div>
        <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="false">
            <HeaderStyle BackColor="#507CD1" Font-Bold="True" ForeColor="White" />
 				<Columns>
					<asp:BoundField DataField="UID" HeaderText="UserID" />
					<asp:BoundField DataField="Email" HeaderText="Email" />
					<asp:BoundField DataField="DOB" HeaderText="Date of Birth" />
                    <asp:BoundField DataField="AboutME" HeaderText="About Me" />
				</Columns>
        </asp:GridView>
        <br />
        <asp:Button ID="Button2" runat="server" OnClick="Button2_Click" Text="Logout" />
    </form>
</body>
</html>
