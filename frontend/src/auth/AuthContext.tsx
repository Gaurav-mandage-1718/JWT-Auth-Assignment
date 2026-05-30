import { createContext, useContext, useState } from "react";
import type { ReactNode } from "react";
import type { Role } from "../types/auth";

interface AuthContextType {
  token: string | null;
  role: Role | null;
  logout: () => void;
}

const AuthContext = createContext<AuthContextType | null>(null);

export function AuthProvider({ children }: { children: ReactNode }) {
  const [token, setToken] = useState(localStorage.getItem("token"));
  const [role, setRole] = useState<Role | null>(
    localStorage.getItem("role") as Role | null
  );

  const logout = () => {
    localStorage.clear();
    setToken(null);
    setRole(null);
  };

  return (
    <AuthContext.Provider value={{ token, role, logout }}>
      {children}
    </AuthContext.Provider>
  );
}

export function useAuth() {
  const auth = useContext(AuthContext);

  if (!auth) {
    throw new Error("useAuth must be used inside AuthProvider");
  }

  return auth;
}