import { useEffect, useMemo, useState } from "react";
import UserContext from "services/contexts/contexts/UserContext";
import { Info } from "services/api/UserService";
import { toast } from "react-toastify";
import SpinnerView from "components/common/SpinnerView/SpinnerView";

const UserProvider = ({ children }) => {
  const [user, setUser] = useState(null);
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    refresh();
  }, []);

  const refresh = () => {
    setIsLoading(true);
    Info().then((res) => {
      if (!res.isSuccesfull) {
        toast.error(res.message, {
          position: toast.POSITION.BOTTOM_RIGHT,
        });
        return;
      }
      setUser(res.data);
      setIsLoading(false);
    });
  };

  const contextValue = useMemo(
    () => ({
      user,
      setUser,
      refresh,
    }),
    [user]
  );

  return (
    <SpinnerView isLoading={isLoading}>
      <UserContext.Provider value={contextValue}>
        {children}
      </UserContext.Provider>
    </SpinnerView>
  );
};

export default UserProvider;
