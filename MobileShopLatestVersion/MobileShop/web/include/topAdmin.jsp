
<style>
.header-class 
{
   background-color: lightblue;
   color:black;
   padding: 1px;
}

.header-class h3 
{
    text-align: left;
    font-family: monospace, cursive;
    padding-left:10px;
}

.header-class img {
    height: 35px;
    width: 100px;
}

.heared-class-con 
{
    top:0px;
    width: 100%;
    position: fixed;
    margin-left: 0px;
}
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: inherit;
}

li {
    float: left;
    padding-left:10px;
}

li a, .dropbtn {
    display: inline-block;
    color: black;
    text-align: center;
    padding: 5px 10px;
    text-decoration: none;
}

li a:hover, .dropdown:hover .dropbtn {
    background-color: cornflowerblue;
}


li.dropdown {
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: white;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
    
}

.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    text-align: left;
}

.dropdown-content a:hover {background-color: #f1f1f1}



.dropdown:hover .dropdown-content {
    display: block;
}
</style>

<div class="heared-class-con">
<div class="header-class">
    <a href="adminpage.jsp"><h3><img src="slike/logo/phone.png" alt="phone"/></a> WEB PRODAVNICA MOBILNIH TELEFONA</h3>
    <ul>
        <li>
            <a href="adminpage.jsp">Korisnici</a>
        </li>
        <li>
            <a href="noviModel.jsp">Ubaci novi model</a>
        </li>
        <li>
            <a href="noveMogucnosti.jsp">Dodaj nove specifikacije</a>
        </li>
        <li>
             <a href="updateModel.jsp">Azuriraj model</a>
        </li>
        <li>
            <a href="logoutServlet?action=logout">Izloguj se</a>
        </li>
    </ul>
</div>
</div>