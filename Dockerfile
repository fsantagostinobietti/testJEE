FROM jboss/wildfly:8.2.0.Final

# Openshift hack (see https://github.com/jboss-dockerfiles/wildfly/issues/25)
USER root
RUN chown -R jboss:0 ${JBOSS_HOME} \
    && chmod -R g+rw ${JBOSS_HOME}
USER jboss

COPY ["target/testJEE.war", "/opt/jboss/wildfly/standalone/deployments/testJEE.war"]

# setup UFT-8 encoding 
ENV LANG en_US.utf8  
ENV LANGUAGE en_US:en  
ENV LC_ALL en_US.utf8 
# set heroku PORT var (use same value as exported docker port)
ENV PORT 8080

# add admin user
RUN /opt/jboss/wildfly/bin/add-user.sh admin admin --silent

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0", "-Djboss.http.port=$PORT"]
