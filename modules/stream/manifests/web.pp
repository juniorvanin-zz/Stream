class stream::web inherits stream {

    class {"java::java8":}

    class {"tomcat::server":
        require => Class["java::java8"],
    }

    class {"mysql::client":
        require => Class["tomcat::server"],
    }

    file_line { "set-tomcat-java-home":
      path => '/etc/default/tomcat7',
      line => 'JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-amd64',
      match   => "#JAVA_HOME.*.\n",
      require => Package["tomcat7"],
    }

    file { "setup-tomcat-manager":
        name    => "/var/lib/tomcat7/conf/tomcat-users.xml",
        replace => true,
        source => "puppet:///modules/stream/tomcat-users.xml",
        require => Package["tomcat7"],
        notify  => Service["tomcat7"],
    }
}