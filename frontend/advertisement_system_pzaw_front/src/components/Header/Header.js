import './Header.css';

function Header(props) {
  return (
    <div className={"bg-primary p-2 " + props.className}>
      <img src="img/logo/logo-no-background.svg" height="50"></img>
    </div>
  );
}

export default Header;
