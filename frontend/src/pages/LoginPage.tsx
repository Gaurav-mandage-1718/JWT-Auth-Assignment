import { useForm } from "react-hook-form";
import { useNavigate, Link } from "react-router-dom";
import api from "../api/axios";
import type { AuthResponse, LoginRequest } from "../types/auth";

function LoginPage() {
  const { register, handleSubmit } = useForm<LoginRequest>();
  const navigate = useNavigate();

  const onSubmit = async (data: LoginRequest) => {
    const response = await api.post<AuthResponse>("/api/auth/login", data);

    localStorage.setItem("token", response.data.token);
    localStorage.setItem("role", response.data.role);
    localStorage.setItem("name", response.data.name);
    localStorage.setItem("email", response.data.email);

    navigate("/dashboard");
  };

 return (
  <div className="page">
    <div className="card">
      <h2>Login</h2>

      <form onSubmit={handleSubmit(onSubmit)}>
        <input placeholder="Email" {...register("email")} />
        <input placeholder="Password" type="password" {...register("password")} />

        <button type="submit">Login</button>
      </form>

      <p>
        New user? <Link to="/register">Register</Link>
      </p>
    </div>
  </div>
);
}

export default LoginPage;