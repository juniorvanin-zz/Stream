class tomcat::server {
    package { ["tomcat7"]:
        ensure  => installed,
    }

    service { "tomcat":
        name        => tomcat7,
        ensure      => running,
        enable      => true,
        hasstatus   => true,
        hasrestart  => true,
        require     => Package["tomcat7"],
    }
}