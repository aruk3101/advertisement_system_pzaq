import { useContext } from "react";
import AuthContext from "services/contexts/contexts/AuthContext";

export const useAuth = () => {
  return useContext(AuthContext);
};
