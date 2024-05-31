import axios from "axios";
import { useEffect, useMemo, useState } from "react";
import AuthContext from "services/contexts/contexts/AuthContext";

const AuthProvider = ({ children }) => {
  const [token, setToken_] = useState(localStorage.getItem("token"));
  const [roles, setRoles_] = useState(localStorage.getItem("roles"));

  const setToken = (newToken) => {
    setToken_(newToken);
  };

  const setRoles = (roles) => {
    setRoles_(roles);
  };

  useEffect(() => {
    if (token) {
      axios.defaults.headers.common["Authorization"] = "Bearer " + token;
      localStorage.setItem("token", token);
      localStorage.setItem("roles", roles);
    } else {
      delete axios.defaults.headers.common["Authorization"];
      localStorage.removeItem("token");
      localStorage.removeItem("roles");
    }
  }, [token]);

  const contextValue = useMemo(
    () => ({
      token,
      setToken,
      roles,
      setRoles,
    }),
    [token]
  );

  return (
    <AuthContext.Provider value={contextValue}>{children}</AuthContext.Provider>
  );
};

export default AuthProvider;
