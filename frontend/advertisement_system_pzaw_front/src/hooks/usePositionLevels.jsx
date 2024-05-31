import { useState, useEffect } from "react";
import { GetPositionLevels } from "services/api/PositionLevelService";

const usePositionLevels = () => {
  const [positionLevels, setPositionLevels] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetchItems();
  }, []);

  const fetchItems = () => {
    setLoading(true);
    GetPositionLevels().then((res) => {
      handle(res);
    });
  };

  const handle = (res) => {
    if (res.isSuccesfull) {
      setPositionLevels(res.data);
      setLoading(false);
      return;
    }
  };

  return {
    positionLevels,
    loading,
    fetchItems,
  };
};

export default usePositionLevels;
