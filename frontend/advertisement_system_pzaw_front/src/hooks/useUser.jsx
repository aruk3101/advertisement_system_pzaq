import { useContext } from "react";
import UserContext from "services/contexts/contexts/UserContext";

export const useUser = () => {
  return useContext(UserContext);
};
