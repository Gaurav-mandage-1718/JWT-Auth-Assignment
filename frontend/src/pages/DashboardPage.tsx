import { useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../api/axios";
import { useAuth } from "../auth/AuthContext";

function DashboardPage() {
  const { role, logout } = useAuth();
  const navigate = useNavigate();
  const [message, setMessage] = useState("");

  const name = localStorage.getItem("name");

  const callUserApi = async () => {
    const response = await api.get("/api/user");
    setMessage(response.data);
  };

  const callAdminApi = async () => {
    const response = await api.get("/api/admin");
    setMessage(response.data);
  };

  const handleLogout = () => {
    logout();
    navigate("/login");
  };

return (
  <div className="dashboard">
    <h2>Dashboard</h2>

    <p>Welcome {name}</p>
    <p>Your role is {role}</p>

    <button className="logout" onClick={handleLogout}>
      Logout
    </button>

    {role === "USER" && (
      <div className="content-card">
        <h3>User Section</h3>
        <p>You can access user content.</p>
      </div>
    )}

    {role === "ADMIN" && (
      <div className="content-card">
        <h3>Admin Section</h3>
        <p>You can access admin content.</p>
      </div>
    )}
  </div>
);
}

export default DashboardPage;