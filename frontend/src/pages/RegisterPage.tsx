import { useForm } from "react-hook-form";
import { useNavigate, Link } from "react-router-dom";
import api from "../api/axios";
import type { RegisterRequest } from "../types/auth";

function RegisterPage() {
  const { register, handleSubmit } = useForm<RegisterRequest>();
  const navigate = useNavigate();

  const onSubmit = async (data: RegisterRequest) => {
    await api.post("/api/auth/register", data);
    navigate("/login");
  };

 return (
  <div className="page">
    <div className="card">
      <h2>Register</h2>

      <form onSubmit={handleSubmit(onSubmit)}>
        <input placeholder="Name" {...register("name")} />
        <input placeholder="Email" {...register("email")} />
        <input placeholder="Password" type="password" {...register("password")} />

        <select {...register("role")}>
          <option value="USER">USER</option>
          <option value="ADMIN">ADMIN</option>
        </select>

        <button type="submit">Register</button>
      </form>

      <p>
        Already have account? <Link to="/login">Login</Link>
      </p>
    </div>
  </div>
);
}

export default RegisterPage;