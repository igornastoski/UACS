<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="ConsumingAPICodeBehind.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
        <asp:GridView ID="gvCustomers" runat="server" AutoGenerateColumns="false">
            <Columns>
                <asp:BoundField ItemStyle-Width="150px" DataField="FirstName" HeaderText="First Name" />
                <asp:BoundField ItemStyle-Width="150px" DataField="LastName" HeaderText="Last Name" />
                <asp:BoundField ItemStyle-Width="150px" DataField="Gender" HeaderText="Gender" />
                <asp:BoundField ItemStyle-Width="150px" DataField="Salary" HeaderText="Salary" />
            </Columns>
        </asp:GridView>
        </div>
    </form>
</body>
</html>
