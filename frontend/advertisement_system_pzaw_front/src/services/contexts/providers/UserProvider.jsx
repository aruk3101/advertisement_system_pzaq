import { useEffect, useMemo, useState } from "react";
import UserContext from "services/contexts/contexts/UserContext";
import { Info } from "services/api/UserService";
import { toast } from "react-toastify";

const UserProvider = ({ children }) => {
  const [user, setUser] = useState({});
  const [isLoading, setIsLoading] = useState(false);

  useEffect(() => {
    setIsLoading(true);
    Info().then((res) => {
      setIsLoading(false);
      if (!res.isSuccesfull) {
        toast.error(res.message, {
          position: toast.POSITION.BOTTOM_RIGHT,
        });
        return;
      }
      setUser(res.data);
    });
  }, []);

  const contextValue = useMemo(
    () => ({
      user,
    }),
    [user]
  );

  return (
    <UserContext.Provider value={contextValue}>{children}</UserContext.Provider>
  );
};

export default UserProvider;
